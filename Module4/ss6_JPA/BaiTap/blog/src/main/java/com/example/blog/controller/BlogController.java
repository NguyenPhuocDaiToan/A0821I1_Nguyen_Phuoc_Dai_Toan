package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ModelAndView getListProduct(@PageableDefault(size = 5) Pageable pageable) {
        return new ModelAndView("list", "blogs", blogService.getAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Blog blog) {
        if (blog != null) {
            blogService.save(blog);
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam("search_key") Optional<String> search_key, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogs;
        if (search_key.isPresent()) {
            model.addAttribute("search_key", search_key.get());
            blogs = blogService.search(search_key.get(), pageable);
        }else {
            model.addAttribute("search_key", "");
            blogs = blogService.getAll(pageable);
        }
        return new ModelAndView("list", "blogs", blogs);
    }
}
