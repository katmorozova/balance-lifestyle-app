import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class TasksStatisticsCard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 2,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
      color: Colors.white,
      margin: const EdgeInsets.symmetric(horizontal: 4, vertical: 10),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 12.0, vertical: 16.0),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text(
              'TASK STATISTICS',
              style: TextStyle(
                fontSize: 14,
                fontFamily: 'Georgia',
                fontWeight: FontWeight.bold,
                letterSpacing: 1.4,
                color: AppColors.textPrimary,
              ),
            ),
            const SizedBox(height: 14),

            Row(
              children: [
                SizedBox(
                  width: 82,
                  height: 82,
                  child: Stack(
                    alignment: Alignment.center,
                    children: [
                      SizedBox(
                        width: 76,
                        height: 76,
                        child: CircularProgressIndicator(
                          value: 0.78,
                          strokeWidth: 8,
                          backgroundColor: Colors.grey.shade200,
                          valueColor: const AlwaysStoppedAnimation<Color>(
                            AppColors.primary,
                          ),
                        ),
                      ),
                      Text(
                        '78%',
                        style: TextStyle(
                          fontSize: 16,
                          fontFamily: 'Georgia',
                          fontWeight: FontWeight.bold,
                          color: AppColors.textPrimary,
                        ),
                      ),
                    ],
                  ),
                ),
                const SizedBox(width: 22),
                // Cuadrícula de columnas con textos 2x2
                Expanded(
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      // Fila 1: Tasks + Goals
                      Row(
                        children: [
                          Expanded(
                            child: _buildStatItem(
                              color: Colors.green,
                              title: 'Tasks',
                              subtitle: '10/14 done',
                            ),
                          ),
                          const SizedBox(width: 2),
                          Expanded(
                            child: _buildStatItem(
                              color: Colors.orange,
                              title: 'Goals',
                              subtitle: '8/14 done',
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 8),
                      // Fila 2: Habits + To Do
                      Row(
                        children: [
                          Expanded(
                            child: _buildStatItem(
                              color: Colors.amber,
                              title: 'Habits',
                              subtitle: '12/14 done',
                            ),
                          ),
                          const SizedBox(width: 2),
                          Expanded(
                            child: _buildToDoItem(),
                          ),
                        ],
                      ),
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
          height: 24,
          color: color,
          margin: const EdgeInsets.only(right: 6),
        ),
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              title,
              style: TextStyle(
                fontSize: 14,
                fontFamily: 'Georgia',
                fontWeight: FontWeight.bold,
                color: AppColors.textSecondary,
              ),
            ),
            Text(
              subtitle,
              style: TextStyle(
                fontSize: 10.5, 
                fontFamily: 'Georgia',
                color: Colors.grey.shade600
              ),
            ),
          ],
        ),
      ],
    );
  }

  //Widget ToDo
  Widget _buildToDoItem() {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Container(
          width: 3,
          height: 24,
          color: AppColors.textPrimary,
          margin: const EdgeInsets.only(right: 5),
        ),
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'To Do',
              style: TextStyle(
                fontSize: 12,
                fontFamily: 'Georgia',
                fontWeight: FontWeight.bold,
                color: AppColors.textPrimary,
              ),
            ),
            const SizedBox(height: 2),
            Row(
              children: [
                _buildDotLabel(Colors.red, '2/5'),
                const SizedBox(width: 4),
                _buildDotLabel(Colors.orange, '3/5'),
                const SizedBox(width: 4),
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
