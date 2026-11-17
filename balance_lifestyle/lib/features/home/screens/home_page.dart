import 'package:balance_lifestyle/features/home/widgets/profile_header.dart';
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
          padding: const EdgeInsets.all(16.0),
          child: Column(
            children: [
              ProfileHeader(),

              // Aquí debajo irán siguientes piezas:
              // SizedBox(height: 20),
              // WeekCalendar(),
              // TasksStatisticsCard(),
              //CategoryGridItems(),
              //SectorTabs(),
              //MenuNavegador()
            ],
          ),
        ),
      ),
    );
  }
}
