package com.ysmin.blog.Controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplySaveRequestDto { // 필요한 데이터를 한 번에 받을 수 있음

    private int userId;
    private int boardId;
    private String content;
}
