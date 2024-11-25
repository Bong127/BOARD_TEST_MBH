package com.aloha.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.springboot.dto.Board;
import com.aloha.springboot.dto.Page;
import com.aloha.springboot.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Override
    public List<Board> list(Page page) {
        int total =  count();
        page.setTotal(total);
        return boardMapper.list(page);
    }
    @Override
    public Board select(int no) {
        return boardMapper.select(no);
    }
    @Override
    public int insert(Board board) {
        return boardMapper.insert(board);
    }
    @Override
    public int update(Board board) {
        return boardMapper.update(board);
    }
    @Override
    public int delete(int no) {
        return boardMapper.delete(no);
    }
    @Override
    public int count() {
        return boardMapper.count();
    }
}
