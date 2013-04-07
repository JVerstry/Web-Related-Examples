package com.jverstry.Service;

import com.jverstry.DAO.SomeItem;
import com.jverstry.DAO.SomeItemRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
public class SomeItemService {
    
    @Autowired
    private SomeItemRepository someItemRepository;
    
    @PostConstruct
    @Transactional
    public void populate() {
        
        SomeItem si = new SomeItem();
        si.setSomeText("aaa");
        someItemRepository.saveAndFlush(si);
        
        si = new SomeItem();
        si.setSomeText("bbb");
        someItemRepository.saveAndFlush(si);
        
        si = new SomeItem();
        si.setSomeText("ccc");
        someItemRepository.saveAndFlush(si);
        
    }
    
    @Transactional(readOnly=true)
    public List<SomeItem> getAll() {
        
        return someItemRepository.findAll();
        
    }
    
    @SuppressWarnings("AssignmentToMethodParameter")
    @Transactional
    public SomeItem saveAndFlush(SomeItem si) {
        
        if ( si != null ) {
            si = someItemRepository.saveAndFlush(si);
        }
        
        return si;
        
    }
    
    @Transactional    
    public void delete(long id) {
        
        someItemRepository.delete(id);
        
    }
    
}