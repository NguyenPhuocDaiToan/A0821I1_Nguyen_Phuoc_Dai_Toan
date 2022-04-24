package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/view/{id}")
    public ModelAndView getViewDetail(@PathVariable Integer id) {
        return new ModelAndView("view_detail", "blog", blogService.getById(id));
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

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = blogService.getById(id);

        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog);
            modelAndView.addObject("categories", categoryService.getAll());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("categories", categoryService.getAll());
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Blog blog = blogService.getById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute() Blog blog) {
        blogService.deleteById(blog.getId());
        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //@GetMapping(value = "/search")
    public List<Blog> searchByName(@RequestParam("search_key") Optional<String> search_key, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogs;
        if (search_key.isPresent()) {
            model.addAttribute("search_key", search_key.get());
            blogs = blogService.search(search_key.get(), pageable);
        }else {
            model.addAttribute("search_key", "");
            blogs = blogService.getAll(pageable);
        }
        return blogs.get().collect(Collectors.toList());
        //return new ModelAndView("list", "blogs", blogs);
    }
}
