package com.xinthe.pms.service.impl;

import com.xinthe.pms.model.Screen;
import com.xinthe.pms.repository.GenericRepository;
import com.xinthe.pms.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value="screenServiceImpl")
@Primary
public class ScreenServiceImpl extends GenericServiceImpl {


    public ScreenServiceImpl(GenericRepository repository) {
        super(repository);
    }
}
