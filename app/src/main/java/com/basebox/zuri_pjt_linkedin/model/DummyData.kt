package com.basebox.zuri_pjt_linkedin.model

import com.basebox.zuri_pjt_linkedin.R

object DummyData {
    val posts  = listOf(PostModel("Daniel Trejo", R.drawable.linkedin_logo_transparent,
        "I was first introduced to computer science when I was 13 because my dad had seen a YouTube video about the importance of coding and the lack of computer science" +
                " education in schools across the U.S." +
                " I was pretty resistant to learning how to code at the time, since I went to a small all-girls school " +
                "where coding wasn't a super popular course of study. My dad ended up challenging me to see which of us could finish" +
                " an online Python class fastest, and after a week he had given up on it and I ended up being super interested in the material"),
        PostModel("Havana Shelby", R.drawable.google_icon1,
            "I am glad to announce that I have joined Google as a senior associate. The language was initially called Oak after an Oak tree that stood outside Gostling's Office. "),
        PostModel("Jide Awosika", R.drawable.linkedin_logo_transparent,
            "Receiving rejection mails can be a hard pill to swallow but it has to be the driving force to landing that dream job. "),
        PostModel("Mande Bulus", R.drawable.js_logo,
            "Tried my hands a few days ago on this UI design and prototype of the Javascript logo. What do you think? The name Javascript came from Netscape support for Java Applets within its browser."),
        PostModel("Peter Pascal", R.drawable.php_logo,
            " I taught myself how to code using online resources throughout middle school, " +
                    "and when I got to high school I was able to take CS classes. Since then, I’ve always known that I want to go into software engineering." +
                    "PHP originall stood for Person Home Page, but it now stands for the recursive initialism PHP: Hypertext Preprocessor.")
    )
}