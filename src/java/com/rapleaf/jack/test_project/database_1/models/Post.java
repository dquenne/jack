
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

public class Post extends ModelWithId {
  // Fields
  private String __title;
  private Long __posted_at_millis;
  private Integer __user_id;

  // Associations
  private final BelongsToAssociation<User> __assoc_user;
  private final HasManyAssociation<Comment> __assoc_comments;

  public Post(int id, final String title, final Long posted_at_millis, final Integer user_id, IDatabases databases) {
    super(id);
    this.__title = title;
    this.__posted_at_millis = posted_at_millis;
    this.__user_id = user_id;
    this.__assoc_user = new BelongsToAssociation<User>(databases.getDatabase1().users(), user_id);
    this.__assoc_comments = new HasManyAssociation<Comment>(databases.getDatabase1().comments(), "commented_on_id", id);
  }

  public String getTitle(){
    return __title;
  }

  public void setTitle(String newval){
    this.__title = newval;
  }

  public Long getPostedAtMillis(){
    return __posted_at_millis;
  }

  public void setPostedAtMillis(Long newval){
    this.__posted_at_millis = newval;
  }

  public Integer getUserId(){
    return __user_id;
  }

  public void setUserId(Integer newval){
    this.__user_id = newval;
  }

  public User getUser() throws IOException {
    return __assoc_user.get();
  }

  public Set<Comment> getComments() throws IOException {
    return __assoc_comments.get();
  }

  @Override
  public Object getField(String fieldName) {
    if (fieldName.equals("title")) {
      return getTitle();
    }
    if (fieldName.equals("posted_at_millis")) {
      return getPostedAtMillis();
    }
    if (fieldName.equals("user_id")) {
      return getUserId();
    }
    throw new IllegalStateException("Invalid field name: " + fieldName);
  }

  public String toString() {
    return "<Post"
      + " title: " + __title
      + " posted_at_millis: " + __posted_at_millis
      + " user_id: " + __user_id
      + ">";
  }
}
