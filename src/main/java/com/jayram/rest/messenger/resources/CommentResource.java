package com.jayram.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jayram.rest.messenger.model.Comment;
import com.jayram.rest.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){ //Accessing Root/Parent resource parameters in Sub Resource
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment){
		return commentService.addComments(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id, Comment comment){
		comment.setId(id);
		return commentService.updateComments(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComments(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		commentService.removeComments(messageId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.getComment(messageId, commentId);
	}
	
}
