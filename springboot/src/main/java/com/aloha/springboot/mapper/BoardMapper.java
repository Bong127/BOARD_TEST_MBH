package com.aloha.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.springboot.dto.Board;
import com.aloha.springboot.dto.Page;

@Mapper
public interface BoardMapper {
    public List<Board> list(Page page);
    public Board select(int no);
    public int insert(Board board);
    public int update(Board board);
    public int delete(int no);
    public int count();
}
