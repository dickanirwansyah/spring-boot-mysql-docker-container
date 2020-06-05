package id.corp.backendservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {

    private Date timestamp;
    private String message;
    private int status;
    private Object data;

}
