package com.example.talaba.Controller;

import com.example.talaba.Dto.TalabaDto;
import com.example.talaba.Dto.UniversitetDTO;
import com.example.talaba.Entity.Manzil;
import com.example.talaba.Entity.Talaba;
import com.example.talaba.Entity.Universitet;
import com.example.talaba.Repository.ManzilRepository;
import com.example.talaba.Repository.UniversitetRespositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UniversitetController {
    @Autowired
    UniversitetRespositary universitetRespositary;
    @Autowired
    ManzilRepository manzilRepository;
    @RequestMapping(value = "/o'qish12", method = RequestMethod.GET)
    public List<Universitet> Uqimoq(){
        List<Universitet> all=universitetRespositary.findAll();
        return all;
    }
    @RequestMapping(value = "/malumot",method = RequestMethod.POST)
    public String Yozmoq(@RequestBody UniversitetDTO universitetDTO){
        Universitet universitet = new Universitet();
        universitet.setNomi(universitetDTO.getNomi());
        Manzil manzil = new Manzil();
        manzil.setViloyat(universitetDTO.getViloyat());
        manzil.setTuman(universitetDTO.getTuman());
        manzil.setKucha(universitetDTO.getKocha());
        manzilRepository.save(manzil);
        universitet.setManzil(manzil);
        universitetRespositary.save(universitet);
        return "Malumotlar saqlandi";
    }

    @RequestMapping(value = "/taxrirlash/{id}", method = RequestMethod.PUT)
    public String taxrirlash(@PathVariable Integer id,@RequestBody UniversitetDTO universitetDTO){
        Optional<Universitet>taxrir=universitetRespositary.findById(id);
        if(!taxrir.isPresent()){
            return "Mavjudmas";
        }
      Universitet universitet= taxrir.get();
        universitet.setNomi(universitetDTO.getNomi());
        Optional<Manzil> optionalManzil = manzilRepository.findById(id);
        Manzil manzil = optionalManzil.get();
        manzil.setViloyat(universitetDTO.getViloyat());
        manzil.setTuman(universitetDTO.getTuman());
        manzil.setKucha(universitetDTO.getKocha());
        manzilRepository.save(manzil);
        universitet.setManzil(manzil);
        universitetRespositary.save(universitet);
        return "Ma'lumot tahrirlandi";
    }
    @RequestMapping(value = "/ochirish/{id}",method = RequestMethod.DELETE)
    public  String ochirish(@PathVariable Integer id){
        Optional<Universitet>delete=universitetRespositary.findById(id);
        if(!delete.isPresent()) return "Bunday id malumot mavjud emas!!!!";
        universitetRespositary.deleteById(id);
        manzilRepository.deleteById(id);
        return "Malumotlar o`chirildi!!!!";
    }

}
