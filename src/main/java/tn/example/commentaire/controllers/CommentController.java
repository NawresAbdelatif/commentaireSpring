package tn.example.commentaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.example.commentaire.entities.Comment;
import tn.example.commentaire.services.CommentService;

import java.util.List;

    @RestController
    @RequestMapping("/api/comments")
    public class CommentController {

        @Autowired
        private CommentService commentService;

        @PostMapping
        public Comment addComment(@RequestBody Comment comment) {
            return commentService.addComment(comment);
        }

        @GetMapping
        public List<Comment> getAllComments() {
            return commentService.getAllComments();
        }

        @PutMapping
        public Comment updateComment(@RequestBody Comment comment) {
            return commentService.updateComment(comment);
        }

        @DeleteMapping("/{id}")
        public void deleteComment(@PathVariable int id) {
            commentService.deleteComment(id);
        }
    }


