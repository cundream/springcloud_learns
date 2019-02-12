import com.github.cundream.eurekafeignuploadclient.EurekaFeignUploadClientApplication;
import com.github.cundream.eurekafeignuploadclient.client.UploadClient;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @auther : lc
 * @Date: 2018/12/28 15:21
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EurekaFeignUploadClientApplication.class)
public class UploadClientTest {

    @Autowired
    private UploadClient uploadClient;

    @Test
    public void testHandleFileUpload() {
        File file = new File("test.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);
        System.out.println("返回结果-----------" + uploadClient.handleFileUpload(multi));

    }


}
