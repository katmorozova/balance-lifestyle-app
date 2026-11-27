import 'package:balance_lifestyle/features/home/widgets/category_grid_items.dart';
import 'package:balance_lifestyle/features/home/widgets/profile_header.dart';
import 'package:balance_lifestyle/features/home/widgets/sector_tabs.dart';
import 'package:balance_lifestyle/features/home/widgets/tasks_statistics_card.dart';
import 'package:balance_lifestyle/features/home/widgets/week_calendar.dart';
import 'package:balance_lifestyle/shared/widgets/bottom_nav_bar.dart';
import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: AppColors.background,
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16.0,vertical: 8.0),
            child: Column(
              children: [
                ProfileHeader(),
                const SizedBox(height: 16),
                WeekCalendar(),
                const SizedBox(height: 14),
                TasksStatisticsCard(),
                const SizedBox(height: 16),
                CategoryGridItems(),
                const SizedBox(height: 8),
                Flexible(
                child: SectorTabs(),
                ),
            
              ],
            ),
        ),
      ),
      bottomNavigationBar: MenuNavegador(),
    );
  }
}
