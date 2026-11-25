import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class ProfileHeader extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(left: 8.0, right: 4.0, top: 4.0),
      child: Row(
      children: [
        CircleAvatar(
          radius: 34,
          backgroundImage: AssetImage('assets/images/ekaterina_image.jpg'),
        ),
        SizedBox(width: 14),

        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                'Ekaterina Morozova',
                style: TextStyle(
                  fontSize: 15,
                  fontFamily: 'Georgia',
                  fontWeight: FontWeight.bold,
                  color: AppColors.textPrimary,
                ),
              ),
              SizedBox(height: 2),

              Text(
                '"Nothing is impossible. Everything is possible"',
                style: TextStyle(
                  fontSize: 10, 
                  fontWeight: FontWeight.bold,
                  color: AppColors.textAccent),
                maxLines: 2,
              ),
            ],
          ),
        ),
      ],
    ),
    );
  }
}
