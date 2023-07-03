export BATCH=$1
cd $BATCH
for i in `ls -lt|grep -i ^d|cut -c46-85`
do
echo "Dir=$i"
cd $i
pwd
cp -u * ../
cd ..
rm -rf  $i
done
mv Index.DAT INDEX.DAT

