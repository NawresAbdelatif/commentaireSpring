package tn.example.commentaire.services;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.example.commentaire.entities.Comment;
import tn.example.commentaire.repositories.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
    public Comment updateComment(Comment comment) {
        // Vérification si le commentaire existe déjà dans la base de données par son ID
        Optional<Comment> existingComment = commentRepository.findById(comment.getId());
        if (existingComment.isPresent()) {
            // Si le commentaire existe, on le met à jour
            Comment updatedComment = existingComment.get();
            updatedComment.setTexte(comment.getTexte()); // Mettez à jour ici les autres champs nécessaires
            // Sauvegarde du commentaire mis à jour
            return commentRepository.save(updatedComment);
        } else {
            // Si le commentaire n'existe pas, on le crée comme un nouveau
            return commentRepository.save(comment);
        }
    }

    public void deleteComment(int id) {
        System.out.println("Attempting to delete comment with ID: " + id);
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            commentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Commentaire non trouvé avec l'ID : " + id);
        }
    }

}


