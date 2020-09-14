package com.company;

import com.company.controllers.FamilyController;
import com.company.dao.CollectionFamilyDao;
import com.company.services.FamilyService;

public class HappyFamilyContext {
    public static FamilyController familyController;

    public static void init() {
        CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();

        FamilyService familyService = new FamilyService(collectionFamilyDao);
        familyController = new FamilyController(familyService);

    }

}
