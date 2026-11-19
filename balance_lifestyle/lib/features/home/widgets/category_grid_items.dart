import 'package:balance_lifestyle/theme/app_colors.dart';
import 'package:flutter/widgets.dart';

class CategoryGridItems extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 24.0, horizontal: 16.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                'BALANCE',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: AppColors.textPrimary,
                ),
              ),
              //aqui va lógica de una seccion selecionada(indicador inferior)
            ],
          ),
          const SizedBox(height: 24),
          Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                'GOALS',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: AppColors.textPrimary,
                ),
              ),
              //aqui va lógica de una seccion selecionada(indicador inferior)
            ],
          ),
          const SizedBox(height: 24),
          Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                'LIFESTYLE',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: AppColors.textPrimary,
                ),
              ),
              //aqui va lógica de una seccion selecionada(indicador inferior)
            ],
          ),
          const SizedBox(height: 24),
        ],
      ),
    );
  }
}
