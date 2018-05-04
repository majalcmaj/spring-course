import okhttp3.*;
import okio.BufferedSink;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;

public class FileUploadTest {

    public static final MediaType MEDIA_TYPE_IMAGE
            = MediaType.parse("image/png");

    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        RequestBody imageFileRB = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_IMAGE;
            }

            @Override
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                try(InputStream fis = new FileInputStream(new File("/home/mc/Pictures/mypic.png"))) {
                    IOUtils.copy(fis, bufferedSink.outputStream());
                }
            }

        };

        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);

        bodyBuilder.addFormDataPart("file", "test.png", imageFileRB);
        bodyBuilder.addFormDataPart("name", "780018");
        bodyBuilder.addFormDataPart("key", "02a6d443ba134068d098f94861f94cef");
        bodyBuilder.addFormDataPart("workshopUserId", "1856");
        bodyBuilder.addFormDataPart("docTypeId", "1");
        bodyBuilder.addFormDataPart("qlId", "330711");

        Request request = new Request.Builder()
                .url("http://localhost:9080/wss-rs-api/api/v1.0/uploadDocument")
                .addHeader("mediaType", "form/multipart")
                .post(bodyBuilder.build())
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            System.out.println(response.body().string());
        }
    }

    public static void main(String[] args) throws Exception {
        new FileUploadTest().run();
    }
}
