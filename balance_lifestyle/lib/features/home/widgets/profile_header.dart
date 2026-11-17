import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class ProfileHeader extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        CircleAvatar(
          radius: 60,
          backgroundImage: AssetImage('assets/images/ekaterina_image.jpg'),
        ),
        SizedBox(width: 24),

        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                'Ekaterina Morozova',
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: AppColors.textPrimary,
                ),
              ),
              SizedBox(height: 4),

              Text(
                '"Nothing is impossible. Everithing is possible"',
                style: TextStyle(fontSize: 14, color: AppColors.textSecondary),
                maxLines: 2,
              ),
            ],
          ),
        ),
      ],
    );
  }
}
