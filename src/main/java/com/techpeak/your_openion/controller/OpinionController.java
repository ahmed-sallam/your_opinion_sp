package com.techpeak.your_openion.controller;

import com.techpeak.your_openion.dto.CreateOpinionDto;
import com.techpeak.your_openion.dto.OpinionDto;
import com.techpeak.your_openion.entity.OpinionEntity;
import com.techpeak.your_openion.service.OpinionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/opinions")
public class OpinionController {

    private final OpinionService opinionService;
    private final ModelMapper mapper;

    @Cacheable("opinions")
    @GetMapping("/{id}")
    public OpinionDto getOpinionById(@PathVariable("id") Long id) {
        return convertOpinionToDto(opinionService.findOpinionById(id));
    }

    @CacheEvict("opinions")
    @PostMapping
    public OpinionDto postOpinion(@Valid @RequestBody CreateOpinionDto dto) {
        OpinionEntity entity = convertOpinionToEntity(dto);
        OpinionEntity newOpinion = opinionService.addOpinion(entity);
        return convertOpinionToDto(newOpinion);
    }
    @CacheEvict("opinions")
    @PutMapping("/{id}")
    public OpinionDto putOpinion( @PathVariable("id") Long id , @Valid @RequestBody OpinionDto dto) {
        if(!id.equals(dto.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not match");
        }
        OpinionEntity entity = convertOpinionFullToEntity(dto);
        OpinionEntity newOpinion = opinionService.updateOpinion(id, entity);
        return convertOpinionToDto(newOpinion);
    }


    @Cacheable("opinions")
    @GetMapping
    public List<OpinionDto> getAllOpinions() {
        return opinionService.findAllOpinons().stream().map(this::convertOpinionToDto).collect(Collectors.toList());
    }

    private OpinionDto convertOpinionToDto(OpinionEntity entity) {
        return mapper.map(entity, OpinionDto.class);
    }

    private OpinionEntity convertOpinionToEntity(CreateOpinionDto dto) {
        return mapper.map(dto, OpinionEntity.class);
    }

    private OpinionEntity convertOpinionFullToEntity(OpinionDto dto) {
        return mapper.map(dto, OpinionEntity.class);
    }

}
