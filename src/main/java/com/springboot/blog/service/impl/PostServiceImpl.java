package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert dto to entity
        Post post = mapEntity(postDto);
        Post newPost = postRepository.save(post);
        //convert entity to DTO
        PostDto postResponse = mapDTO(newPost);
        return  postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();
        //convert list of poat to post dtos
        return posts.stream().map(post -> mapDTO(post)).collect(Collectors.toList());



    }

    //convert entity to DTO
        private PostDto mapDTO(Post post) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setDescription(post.getDescription());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            return postDto;

        }

        private Post mapEntity(PostDto postDto){
            Post post = new Post();
            postDto.setId(postDto.getId());
            post.setTitle(postDto.getTitle());
            post.setDescription(postDto.getDescription());
            post.setContent(postDto.getContent());
            return post;
        }


}
