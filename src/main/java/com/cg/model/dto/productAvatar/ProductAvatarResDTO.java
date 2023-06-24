package com.cg.model.dto.productAvatar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductAvatarResDTO {

    private String id;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
}
