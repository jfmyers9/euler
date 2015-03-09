#! /usr/local/env/ruby

MAX = ARGV[0]

if MAX == nil
  raise ArgumentError.new('specify a max number')
end

divisors = {}
sums = {}
amicable = []

for i in 2..MAX.to_i - 1
  divisors[i] = [1]
  for j in 2..i-1
    divisors[i] << j if i % j == 0
  end
  sums[i] = divisors[i].inject(:+)
  if sums[sums[i]] == i && i != sums[i]
    amicable << i
    amicable << sums[i]
  end
end

p "Sum of amicable numbers under #{MAX} is #{amicable.inject(:+)}"
