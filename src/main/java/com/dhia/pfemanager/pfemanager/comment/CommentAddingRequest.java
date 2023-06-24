package com.dhia.pfemanager.pfemanager.comment;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentAddingRequest {

    String description;
    Integer commenterId;

}
