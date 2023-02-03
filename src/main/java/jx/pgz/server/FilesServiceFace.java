package jx.pgz.server;

import jx.pgz.dao.entity.Files;
import jx.pgz.enums.FileTypeEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilesServiceFace {

    List<Files> upload(MultipartFile[] files, FileTypeEnum fileTypeEnum);

    void download(String fileId);

    boolean delete(String fileId);
}
