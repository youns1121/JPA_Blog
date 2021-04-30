package com.ysmin.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data // Getter, Setter을 사용하겠다
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {



    int status;
    T data;

}
