package com.aloha.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.springboot.dto.Board;
import com.aloha.springboot.dto.Page;
import com.aloha.springboot.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/list")
    public String list(Model model, Page page) {
        List<Board> boardList = boardService.list(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("page", page);
        return "/board/list";
    }
    @GetMapping("/read/{no}")
    public String read(@PathVariable("no") int no, Model model) {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/read";
    }
    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }
    @PostMapping("/insert")
    public String insert(Board board) {
        int result = boardService.insert(board);
        if(result > 0)
            return "redirect:/board/list";
        else
            return "redirect:/board/insert";
    }
    @GetMapping("/update/{no}")
    public String getMethodName(@PathVariable("no") int no, Model model) {
        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/update";
    }
    @PostMapping("/update")
    public String postMethodName(Board board) {
        int result = boardService.update(board);
        if(result > 0)
            return "redirect:/board/list";
        else
            return "redirect:/board/update";
    }
    @PostMapping("/delete/{no}")
    public String delete(@PathVariable("no") int no) {
        int result = boardService.delete(no);
        if(result > 0)
            return "redirect:/board/list";
        else
            return "redirect:/board/delete";
    }
}
