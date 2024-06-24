package com.example.first.job.app.review.service;

import com.example.first.job.app.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean createReview(Long companyId, Review review);
    Review getReviewById(Long companyId, Long reviewId);
}
