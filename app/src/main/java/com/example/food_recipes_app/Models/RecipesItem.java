package com.example.food_recipes_app.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RecipesItem{

	@SerializedName("cookTimeMinutes")
	private int cookTimeMinutes;

	@SerializedName("instructions")
	private List<String> instructions;

	@SerializedName("image")
	private String image;

	@SerializedName("prepTimeMinutes")
	private int prepTimeMinutes;

	@SerializedName("caloriesPerServing")
	private int caloriesPerServing;

	@SerializedName("rating")
	private Float rating;

	@SerializedName("mealType")
	private List<String> mealType;

	@SerializedName("cuisine")
	private String cuisine;

	@SerializedName("userId")
	private int userId;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("difficulty")
	private String difficulty;

	@SerializedName("servings")
	private int servings;

	@SerializedName("reviewCount")
	private int reviewCount;

	@SerializedName("name")
	private String name;

	@SerializedName("ingredients")
	private List<String> ingredients;

	@SerializedName("id")
	private int id;

	public RecipesItem(int cookTimeMinutes, List<String> instructions, String image, int prepTimeMinutes, int caloriesPerServing, Float rating, List<String> mealType, String cuisine, int userId, List<String> tags, String difficulty, int servings, int reviewCount, String name, List<String> ingredients, int id) {
		this.cookTimeMinutes = cookTimeMinutes;
		this.instructions = instructions;
		this.image = image;
		this.prepTimeMinutes = prepTimeMinutes;
		this.caloriesPerServing = caloriesPerServing;
		this.rating = rating;
		this.mealType = mealType;
		this.cuisine = cuisine;
		this.userId = userId;
		this.tags = tags;
		this.difficulty = difficulty;
		this.servings = servings;
		this.reviewCount = reviewCount;
		this.name = name;
		this.ingredients = ingredients;
		this.id = id;
	}

	public int getCookTimeMinutes() {
		return cookTimeMinutes;
	}

	public void setCookTimeMinutes(int cookTimeMinutes) {
		this.cookTimeMinutes = cookTimeMinutes;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrepTimeMinutes() {
		return prepTimeMinutes;
	}

	public void setPrepTimeMinutes(int prepTimeMinutes) {
		this.prepTimeMinutes = prepTimeMinutes;
	}

	public int getCaloriesPerServing() {
		return caloriesPerServing;
	}

	public void setCaloriesPerServing(int caloriesPerServing) {
		this.caloriesPerServing = caloriesPerServing;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public List<String> getMealType() {
		return mealType;
	}

	public void setMealType(List<String> mealType) {
		this.mealType = mealType;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}