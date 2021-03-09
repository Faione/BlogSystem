package stu.swufe.fhl.blog.model;

public class CommentPojoWithBLOBs extends CommentPojo {
    private String parentContent;

    private String content;

    public String getParentContent() {
        return parentContent;
    }

    public void setParentContent(String parentContent) {
        this.parentContent = parentContent == null ? null : parentContent.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}