import 'package:flutter/material.dart';

class AppColors {
  // Private constructor to prevent instantiation
  AppColors._();

  // Primary brand colors
  static const Color primary = Color(0xFF2F4F4F);
  static const Color primaryDark = Color(0xFF5A6E6B);
  static const Color primaryLight = Color(0xFF8C9A98);

  // Secondary / accent colors
  static const Color secondary = Color(0xFFE8A07D);

  // Backgrounds and surfaces
  static const Color background = Color(0xFFF7F4EF);
  static const Color surface = Color(0xFFFFFFFF);
  static const Color backgroundDark = Color(0xFFF8F1E5);

  // Text colors
  static const Color textPrimary = Color(0xFF2F4F4F);
  static const Color textSecondary = Color(0xFF5A6E6B);
  static const Color textOnPrimary = Color(0xFF8C9A98);
  static const Color textAccent = Color(0xFFE8A07D);

  // Status colors
  static const Color success = Color(0xFF4CAF50);
  static const Color warning = Color(0xFFF0AD4E);
  static const Color error = Color(0xFFD9534F);

  // Task priority colors (traffic light)
  static const Color priorityHigh = Color(0xFFD1483E);   // Red
  static const Color priorityMedium = Color(0xFFE5A13B); // Amber
  static const Color priorityLow = Color(0xFF52B249);    // Green
}