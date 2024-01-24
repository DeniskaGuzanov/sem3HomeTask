package com.example.sem3HomeTask.services;
import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private  DataProcessingService getDataProcessingService;
    @Autowired
    private  UserService userService;
    @Autowired
    private  NotificationService notificationService;

    public RegistrationService() {
    }

    public void processRegistration(User user) {
        getDataProcessingService.getRepository().saveUser(user);
        notificationService.sendNotification("user create and added to list");
    }

    public UserService getUserService() {
        return userService;
    }

    public DataProcessingService getDataProcessingService() {
        return getDataProcessingService;
    }
}
