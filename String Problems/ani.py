def count_groups(n, compatibilities):
    # Create a dictionary to count the frequency of each compatibility factor
    frequency = {}
    for factor in compatibilities:
        if factor in frequency:
            frequency[factor] += 1
        else:
            frequency[factor] = 1
    
    # Calculate the number of groups that can be formed
    groups = 0
    for count in frequency.values():
        if count >= 2:
            groups += count // 2
    
    return groups



n2 = 6
compatibilities2 = [1, 1, 1, 2, 2, 2]
print("Sample Output 2:", count_groups(n2, compatibilities2))
