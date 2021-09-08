package com.hebe.imgUpload;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageManagerService {

    private final FileManager fileManager;
    private final UploadImageS3 uploadImageS3;

    // 임시 파일 생성 & 업데이트 & 임시 파일 삭제
    public void createAndUploadFile(MultipartFile mf, String filePath) {
        String saveFileName = UUID.randomUUID().toString();

        // 파일 생성
        File uploadFile = null;
        try {
            Optional<File> uploadFileOpt = fileManager.convertMultipartFileToFile(mf);
            if (uploadFileOpt.isEmpty()) {
                System.out.println("파일 변환에 실패했습니다.");
            }
            uploadFile = uploadFileOpt.get();

            // 파일 업로드
            String saveFilePath = uploadImageS3.upload(uploadFile, filePath, saveFileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 업로드 하던 중 에러가 발생했습니다.");
        } finally {
            // 파일 삭제
            if (uploadFile != null) {
                uploadFile.delete();
            }
        }
    }
}
