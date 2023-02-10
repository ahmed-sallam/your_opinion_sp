package com.techpeak.your_openion.service;

import com.techpeak.your_openion.entity.OpinionEntity;
import com.techpeak.your_openion.exception.NotFoundException;
import com.techpeak.your_openion.repo.OpinionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;

    public List<OpinionEntity> findAllOpinons(){
        return opinionRepository.findAll();
    }


    public OpinionEntity findOpinionById(Long id){
        return findOrThrow(id);
    }

    public OpinionEntity addOpinion(OpinionEntity opinion){
        return opinionRepository.save(opinion);
    }

    public OpinionEntity updateOpinion(Long id, OpinionEntity opinion){
        findOrThrow(id);
       return opinionRepository.save(opinion);
    }

    // this also good if we have update method
    public OpinionEntity findOrThrow(Long id){
        return opinionRepository.findById(id).orElseThrow(()->new NotFoundException("Opinion with id " + id +" not found"));
    }
}
