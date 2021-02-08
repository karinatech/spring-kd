package com.topic;

import com.models.Topic;
import com.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepo topicRepo;

    List<Topic> topics= new ArrayList<>(Arrays.asList(
            new Topic("Spring","Spring framework","spring description"),
            new Topic("MVC","Spring framework","mvc description"),
            new Topic("REST","Spring framework","rest description")
    ));

    public List<Topic>getAllTopics(){
        List<Topic>list = new ArrayList<>();
         topicRepo.findAll()
                .forEach(list::add);
         return list;
    }
    public Optional<Topic> getTopic(String id){
    return topicRepo.findById(id);
    }
    public void addTopic(Topic topic){
        topicRepo.save(topic);
    }
    public void deleteTopic(String id){
        topicRepo.deleteById(id);
    }


}
