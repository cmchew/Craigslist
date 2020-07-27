package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

    @Component
    public class DataLoader implements CommandLineRunner {

        @Autowired
        UserRepository userRepository;

        @Autowired
        JobRepository jobRepository;

        @Override
        public void run(String... strings) throws Exception {

            //Define a user
            User user1 = new User();
            user1.setName("Sue");
            user1.setTask("Curates leadership roles");

            User user2 = new User();
            user2.setName("Nora");
            user2.setTask("Curates coding and programming opportunities");

            User user3 = new User();
            user3.setName("Ray");
            user3.setTask("Matches clients with web designers");

            Job job1 = new Job();
            job1.setTitle("Java Developer");
            job1.setDescription("Develop contact tracing application for Maryland Department of Health");
            job1.setPostedDate("July 27");
            job1.setPhone("301-555-5555");
            job1.setAuthor("Sue");
            job1.setUser(user1);

            Job job2= new Job();
            job2.setTitle("Technical Writer");
            job2.setDescription("Prepare pseudocode for team of remote java programmers for new job application.");
            job2.setPostedDate("July 27");
            job2.setPhone("301-555-5555");
            job2.setAuthor("Sue");
            job2.setUser(user1);

            Job job3 = new Job();
            job3.setTitle("Engineer");
            job3.setDescription("Develop website ordering system for national restaurant");
            job3.setPostedDate("July 27");
            job3.setPhone("301-555-5555");
            job3.setAuthor("Sue");
            job3.setUser(user1);

            Job job4 = new Job();
            job4.setTitle("Internship");
            job4.setDescription("Assist on research team for new website");
            job4.setPostedDate("July 27");
            job4.setPhone("301-555-5555");
            job4.setAuthor("Nora");
            job4.setUser(user2);

            Job job5 = new Job();
            job5.setTitle("WordPress Developer");
            job5.setDescription("Develop WordPress website for media company");
            job5.setPostedDate("July 27");
            job5.setPhone("301-555-5555");
            job5.setAuthor("Nora");
            job5.setUser(user2);

            Job job6 = new Job();
            job6.setTitle("Junior Developer");
            job6.setDescription("Assist on development of mobile app");
            job6.setPostedDate("July 27");
            job6.setPhone("301-555-5555");
            job6.setAuthor("Nora");
            job6.setUser(user2);

            Job job7 = new Job();
            job7.setTitle("Internship");
            job7.setDescription("Assist on research team for new website");
            job7.setPostedDate("July 27");
            job7.setPhone("301-555-5555");
            job7.setAuthor("Ray");
            job7.setUser(user3);

            Job job8 = new Job();
            job8.setTitle("Designer");
            job8.setDescription("Redesign non-profit website");
            job8.setPostedDate("July 27");
            job8.setPhone("301-555-5555");
            job8.setAuthor("Ray");
            job8.setUser(user3);

            Job job9 = new Job();
            job9.setTitle("Full Stack Developer");
            job9.setDescription("Build front and back end for chef's website");
            job9.setPostedDate("July 27");
            job9.setPhone("301-555-5555");
            job9.setAuthor("Ray");
            job9.setUser(user3);



            //Add the task to an empty list
            Set<Job> jobs = new HashSet<Job>();
            jobs.add(job1);
            jobs.add(job2);
            jobs.add(job3);
            jobs.add(job4);
            jobs.add(job5);
            jobs.add(job6);
            jobs.add(job7);
            jobs.add(job8);
            jobs.add(job9);




            //Add the list of jobs to the user's job list
            user1.setJobs(jobs);
            user2.setJobs(jobs);
            user3.setJobs(jobs);


            //Save the user to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            jobRepository.save(job1);
            jobRepository.save(job2);
            jobRepository.save(job3);
            jobRepository.save(job4);
            jobRepository.save(job5);
            jobRepository.save(job6);
            jobRepository.save(job7);
            jobRepository.save(job8);
            jobRepository.save(job9);







        }
    }

