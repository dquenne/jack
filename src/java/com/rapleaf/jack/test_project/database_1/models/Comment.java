
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
/* generated from migration version 20110324000133 */
package com.rapleaf.jack.test_project.database_1.models;

import java.io.IOException;
import java.util.Set;

import com.rapleaf.jack.test_project.database_1.IDatabase1;

import com.rapleaf.jack.ModelWithId;
import com.rapleaf.jack.BelongsToAssociation;
import com.rapleaf.jack.HasManyAssociation;
import com.rapleaf.jack.HasOneAssociation;

import com.rapleaf.jack.test_project.IDatabases;

public class Comment extends ModelWithId {
  // Fields
  private String __content;
  private Integer __commenter_id;
  private Integer __commented_on_id;

  // Associations
  private final BelongsToAssociation<User> __assoc_user;
  private final BelongsToAssociation<Post> __assoc_post;

  public Comment(int id, final String content, final Integer commenter_id, final Integer commented_on_id, IDatabases databases) {
    super(id);
    this.__content = content;
    this.__commenter_id = commenter_id;
    this.__commented_on_id = commented_on_id;
    this.__assoc_user = new BelongsToAssociation<User>(databases.getDatabase1().users(), commenter_id);
    this.__assoc_post = new BelongsToAssociation<Post>(databases.getDatabase1().posts(), commented_on_id);
  }

  public String getContent(){
    return __content;
  }

  public void setContent(String newval){
    this.__content = newval;
  }

  public Integer getCommenterId(){
    return __commenter_id;
  }

  public void setCommenterId(Integer newval){
    this.__commenter_id = newval;
  }

  public Integer getCommentedOnId(){
    return __commented_on_id;
  }

  public void setCommentedOnId(Integer newval){
    this.__commented_on_id = newval;
  }

  public User getUser() throws IOException {
    return __assoc_user.get();
  }

  public Post getPost() throws IOException {
    return __assoc_post.get();
  }

  @Override
  public Object getField(String fieldName) {
    if (fieldName.equals("content")) {
      return getContent();
    }
    if (fieldName.equals("commenter_id")) {
      return getCommenterId();
    }
    if (fieldName.equals("commented_on_id")) {
      return getCommentedOnId();
    }
    throw new IllegalStateException("Invalid field name: " + fieldName);
  }

  public String toString() {
    return "<Comment"
      + " content: " + __content
      + " commenter_id: " + __commenter_id
      + " commented_on_id: " + __commented_on_id
      + ">";
  }
}
