package com.courseApp.driver.cmdline.commands.ReviewServiceCommand;

import com.courseApp.reviewService.ReviewServiceController;
import com.courseApp.driver.cmdline.IShellState;


import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class EditUserReview extends ReviewCommand {

    public EditUserReview(){
        super(6, 6);
    }


    @Override
    public String executeCommand(IShellState shellState, List<String> arguments) throws Throwable {
        checkArgumentsNum(arguments);
        ReviewServiceController reviewController = new ReviewServiceController();
        boolean result = false;
        String courseCode = arguments.get(0);
        String instName = arguments.get(1);
        String username = arguments.get(2);
        double generalRate = Double.parseDouble(arguments.get(3));
        double difficultyRate = Double.parseDouble(arguments.get(4));
        String reviewString =arguments.get(5);

        try{
            result = reviewController.editUserReview(
                    courseCode, instName, username, generalRate, difficultyRate, reviewString);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        if (result){return "Created new user review successfully";}
        else {return "Failed to create user review";}
    }
}
