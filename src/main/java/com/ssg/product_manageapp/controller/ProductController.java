package com.ssg.product_manageapp.controller;

import com.ssg.product_manageapp.dto.ProductDTO;
import com.ssg.product_manageapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // 리스트
    @RequestMapping("/list")
    public void list(String pname,Model model){
        log.info("todo list");
        if(pname == null){
            model.addAttribute("dtoList", productService.getAll(("")));
        }
        else{
            model.addAttribute("dtoList",productService.getAll(pname));
        }
    }

    // 상품 등록
    @GetMapping("/register")
    public void register(){
        log.info("todo register ~~이야");
    }

    @PostMapping("/register")
    public String register(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("Post product register이야~");
        if(bindingResult.hasErrors()){
            log.info("has errors ...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/product/register";
        }

        log.info(productDTO);
        productService.register(productDTO);
        return "redirect:/product/list";
    }

    // 상품 조회(todo/read?tno=xx 요런형식)

    @GetMapping("/read")
    public void read(long pno, Model model){
        ProductDTO productDTO = productService.getOne(pno);
        log.info(productDTO);

        model.addAttribute("dto", productDTO);
    }

    // 수정
    @GetMapping( "/modify")
    public void modify(long pno, Model model){
        ProductDTO productDTO = productService.getOne(pno);
        model.addAttribute("dto",productDTO);
        //"dto"라는 이름으로 todoDTO를 모델에 추가하면 이후 뷰에서 "dto"라는 이름으로 해당 DTO에 접근
    }

    @PostMapping("/modify")
    public String modify(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info(productDTO);
        if(bindingResult.hasErrors()){
            log.info("has errors ...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("pno",productDTO.getPno());
            return "redirect:/product/modify";
        }
        log.info(productDTO);
        productService.modify(productDTO);
        return "redirect:/product/list";
    }


    // @Valid 어노테이션을 사용하여 유효성 검사를 수행하며, TodoDTO 객체를 받습니다. BindingResult는 유효성 검사 결과를 담고 있고, RedirectAttributes는 리다이렉트 시 속성을 전달하는 데 사용


    // 삭제
    @PostMapping("/remove")
    public String remove(long pno, RedirectAttributes redirectAttributes){
        log.info(pno);
        productService.remove(pno);
        return "redirect:/product/list";
    }
}

