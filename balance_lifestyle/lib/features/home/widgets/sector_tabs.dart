import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/material.dart';

class SectorTabs extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 4.0, vertical: 3.0),
      child: GridView.count(
        crossAxisCount: 3,
        mainAxisSpacing: 10.0,
        crossAxisSpacing: 12.0,
        childAspectRatio: 1.15,
        shrinkWrap: true,
        physics: const NeverScrollableScrollPhysics(),
        children: [
          _createCard('Wheel', 'assets/images/wheelColor.png'),
          _createCard('Goals', 'assets/images/goal.png'),
          _createCard('Wishlist', 'assets/images/wishlist.png'),
          _createCard('Habits', 'assets/images/interval.png'),
          _createCard('Planning', 'assets/images/project.png'),
          _createCard('Travel', 'assets/images/travel.png'),
          _createCard('Meditation', 'assets/images/lotus.png'),
          _createCard('To Do', 'assets/images/productivity.png'),
          _createCard('Weekly', 'assets/images/menu.png'),
        ],
      ),
    );
  }

  Widget _createCard(String title, String imageRoute) {
    return Card(
      color: Colors.white,
      elevation: 2,
      shadowColor: Colors.black26,
      clipBehavior: Clip.antiAlias,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(22.0)),
       child: InkWell(
        onTap: () {
          // Acción al tocar cada sección
        },
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 4.0, vertical: 6.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Flexible(
              child: Padding(
                  padding: const EdgeInsets.all(4.0),
                  child: Image.asset(
                    imageRoute,
                    fit: BoxFit.contain,
                  ),
                ),
            ),
            const SizedBox(height: 4),
            Text(
              title,
              textAlign: TextAlign.center,
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
              style: const TextStyle(
                fontSize: 9.5,
                fontFamily: 'Georgia',
                fontWeight: FontWeight.w600,
                color: AppColors.textSecondary,
              ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
