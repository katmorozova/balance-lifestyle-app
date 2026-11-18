import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class TasksStatisticsCard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 2,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
      color: Colors.white,
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text(
              'TASK STATISTICS',
              style: TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
                letterSpacing: 1.2,
                color: AppColors.textPrimary,
              ),
            ),
            const SizedBox(height: 20),

            Row(
              children: [
                SizedBox(
                  width: 200,
                  height: 250,
                  child: Stack(
                    alignment: Alignment.center,
                    children: [
                      SizedBox(
                        width: 150,
                        height: 150,
                        child: CircularProgressIndicator(
                          value: 0.78,
                          strokeWidth: 12,
                          backgroundColor: Colors.grey.shade200,
                          valueColor: const AlwaysStoppedAnimation<Color>(
                            AppColors.primary,
                          ),
                        ),
                      ),
                      Text(
                        '78%',
                        style: TextStyle(
                          fontSize: 22,
                          fontWeight: FontWeight.bold,
                          color: AppColors.textPrimary,
                        ),
                      ),
                    ],
                  ),
                ),
                const SizedBox(width: 20),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      _buildStatItem(
                        color: Colors.green,
                        title: 'Tasks',
                        subtitle: '10/14 completed',
                      ),
                      const SizedBox(height: 12),
                      _buildStatItem(
                        color: Colors.orange,
                        title: 'Goals',
                        subtitle: '8/14 completed',
                      ),
                      const SizedBox(height: 12),
                      _buildStatItem(
                        color: Colors.amber,
                        title: 'Habits',
                        subtitle: '12/14 completed',
                      ),
                      const SizedBox(height: 12),
                      _buildToDoItem(),
                    ],
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildStatItem({
    required Color color,
    required String title,
    required String subtitle,
  }) {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Container(
          width: 3,
          height: 35,
          color: color,
          margin: const EdgeInsets.only(right: 8),
        ),
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              title,
              style: TextStyle(
                fontSize: 14,
                fontWeight: FontWeight.bold,
                color: AppColors.textPrimary,
              ),
            ),
            Text(
              subtitle,
              style: TextStyle(fontSize: 12, color: Colors.grey.shade600),
            ),
          ],
        ),
      ],
    );
  }

  //Widget ToDo
  Widget _buildToDoItem() {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Container(
          width: 3,
          height: 50,
          color: AppColors.textPrimary,
          margin: const EdgeInsets.only(right: 8),
        ),
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'To Do',
              style: TextStyle(
                fontSize: 14,
                fontWeight: FontWeight.bold,
                color: AppColors.textPrimary,
              ),
            ),
            const SizedBox(height: 4),
            Row(
              children: [
                _buildDotLabel(Colors.red, '2/5'),
                const SizedBox(width: 8),
                _buildDotLabel(Colors.orange, '3/5'),
                const SizedBox(width: 8),
                _buildDotLabel(Colors.green, '4/5'),
              ],
            ),
          ],
        ),
      ],
    );
  }

  //Puntos de color de ToDo
  Widget _buildDotLabel(Color color, String text) {
    return Row(
      children: [
        Container(
          width: 6,
          height: 6,
          decoration: BoxDecoration(
            color: color,
            shape: BoxShape.circle,
          ),
        ),
        const SizedBox(width: 4),
        Text(
          text,
          style: TextStyle(
            fontSize: 11,
            color: Colors.grey.shade600,
            fontWeight: FontWeight.w500,
          ),
        ),
      ],
    );
  }
}
