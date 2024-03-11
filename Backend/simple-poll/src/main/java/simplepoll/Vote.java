/*
 * to view the database values, go to:
 * http://localhost:8080/h2-ui
 * credentials: user, pass
 */

 package simplepoll;

 import jakarta.persistence.*;
 
 @Entity
 @Table(name = "vote")
 public class Vote {
     private Integer pollId;
     private Integer optionId;
     private Integer votes;
 
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
 
     public Vote() {
 
     }
 
     public Vote(Integer pollId, Integer optionId, Integer votes) {
         this.pollId = pollId;
         this.optionId = optionId;
         this.votes = votes;
     }
 
     public Integer getPollId() {
         return pollId;
     }
 
     public void setPollId(Integer pollId) {
         this.pollId = pollId;
     }
 
     public Integer getOptionId() {
         return optionId;
     }
 
     public void setOptionId(Integer optionId) {
         this.optionId = optionId;
     }
 
     public Integer getVotes() {
         return votes;
     }
 
     public void setVotes(Integer votes) {
         this.votes = votes;
     }
 
     public Integer getId() {
         return id;
     }
 
     public void setId(Integer id) {
         this.id = id;
     }
 }
 