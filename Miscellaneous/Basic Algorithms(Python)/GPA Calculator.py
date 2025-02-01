print("---GPA Score Calculator---")

grade_dict = {'A+': 4.5, 'A': 4.0, 'B+': 3.5, 'B': 3.0,
              'C+': 2.5, 'C': 2.0, 'D+': 1.5, 'D': 1.0, 'F': 0.0}
total_score = 0
total_credit = 0
P_credit = 0
graduate = False

while not graduate:
    grade = input("Enter grade (or any other key to finish): ")
    if grade in grade_dict.keys():
        try:
            credit = int(input("Enter credit: "))
        except ValueError:
            print("Please enter a valid number for credit.")
            continue
        total_score += grade_dict[grade] * credit
        total_credit += credit
    elif grade == 'P':
        try:
            credit = int(input("Enter credit for Pass: "))
        except ValueError:
            print("Please enter a valid number for credit.")
            continue
        P_credit += credit
    else:
        graduate = True

if total_credit > 0:
    print(f'Your GPA score is {total_score/total_credit:.2f} and you have earned totally {total_credit + P_credit} credits.')
else:
    print("No valid courses were entered for GPA calculation.")
