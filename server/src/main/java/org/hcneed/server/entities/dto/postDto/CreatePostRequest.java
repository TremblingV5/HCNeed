package org.hcneed.server.entities.dto.postDto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = "发帖请求")
public class CreatePostRequest {

    @Parameter(name = "title", description = "新帖子标题")
    private String title;

    @Parameter(name = "content", description = "新帖子内容")
    private String content;

    @Parameter(name = "forum_id", description = "新帖子所属的论坛id")
    private Long forumId;

}
