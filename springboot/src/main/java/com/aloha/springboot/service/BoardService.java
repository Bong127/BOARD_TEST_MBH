package com.aloha.springboot.service;

import java.util.List;

import com.aloha.springboot.dto.Board;
import com.aloha.springboot.dto.Page;

public interface BoardService {
    public List<Board> list(Page page);
    public Board select(int no);
    public int insert(Board board);
    public int update(Board board);
    public int delete(int no);
    public int count();
}
