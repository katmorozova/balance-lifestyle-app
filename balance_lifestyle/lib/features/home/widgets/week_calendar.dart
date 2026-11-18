import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class WeekCalendar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final now = DateTime.now();
    //Looking Monday to the week
    final startOfWeek = now.subtract(Duration(days: now.weekday - 1));
    const weekDays = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'];

    return Padding(
      padding: const EdgeInsets.symmetric(
        vertical: 16.0, 
        horizontal: 8.0
      ),
  
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: List.generate(7,(index) {
            final currentDay = startOfWeek.add(Duration(days:index));
            final isToday = currentDay.day == now.day &&
              currentDay.month == now.month &&
              currentDay.year == now.year;

            return Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Text(
                    weekDays[index],
                    style: TextStyle(
                      fontSize: 16,
                      fontWeight: FontWeight.bold,
                      color: AppColors.textPrimary,
                    ),
                  ),
                const SizedBox(height: 8),

                Container(
                  width: 36,
                  height: 36,
                  alignment: Alignment.center,
                  decoration: BoxDecoration(
                    color: isToday ? AppColors.textPrimary : Colors.white,
                    shape: BoxShape.circle,
                  ),
                  child: Text(
                    '${currentDay.day}',
                    style: TextStyle(
                      fontSize: 16,
                      fontWeight: FontWeight.bold,
                      color: isToday ? Colors.white : AppColors.textPrimary,
                    ),
                  ),
                ),
            ],
          );    
        }),
      ),
    );
  }
}